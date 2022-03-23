def prepareArtifacts() {
  stage('Prepare Artifacts') {
    if(COMPONENT == "frontend") {
      sh '''
        zip -r ${COMPONENT}.zip static
      '''
    }
  }
}
