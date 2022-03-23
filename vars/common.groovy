def prepareArtifacts() {
  stage('Prepare Artifacts') {
    if(COMPONENT == "frontend") {
      sh '''
        ls -ltr
        zip -r ${COMPONENT}.zip static
      '''
    }
  }
}
