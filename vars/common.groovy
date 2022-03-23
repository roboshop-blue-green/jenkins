def prepareArtifacts() {
  stage('Prepare Artifacts') {
    if(COMPONENT == "frontend") {
      sh '''
        ls -l
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'`
        cd static
        zip -r ../${COMPONENT}-${APP_VERSION}.zip * 
      '''
    }
  }
}

def publishArtifacts() {
  stage('Publish Artifacts') {
    sh '''
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'`
        curl -f -v -u admin:admin --upload-file ${COMPONENT}-${APP_VERSION}.zip  http://172.31.8.57:8081/repository/${COMPONENT}/${COMPONENT}-${APP_VERSION}.zip
      '''
  }
}

