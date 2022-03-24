def prepareArtifacts() {
  stage('Prepare Artifacts') {
    if(COMPONENT == "frontend") {
      sh '''
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'`
        cd static
        zip -r ../${COMPONENT}-${APP_VERSION}.zip * 
      '''
    }
    if(APP_TYPE == "nodejs") {
      sh '''
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'`
        npm install
        zip -r ${COMPONENT}-${APP_VERSION}.zip node_modules server.js
      '''
    }
    if(APP_TYPE == "maven") {
      sh '''
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'`
        mvn clean package && mv target/shipping-1.0.jar shipping.jar 
        zip -r ${COMPONENT}-${APP_VERSION}.zip shipping.jar
      '''
    }
    if(APP_TYPE == "python") {
      sh '''
        APP_VERSION=`cat VERSION.md | grep ^# | head -1 | sed -e 's/#//' -e 's/ //g'` 
        zip -r ${COMPONENT}-${APP_VERSION}.zip *.py *.ini requirements.txt 
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

