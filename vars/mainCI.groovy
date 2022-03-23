def call() {
  node {
    sh 'rm -rf *'
    stage('Checkout Code') {
      checkout scm
    }
    common.prepareArtifacts()
    common.publishArtifacts()
  }
}
