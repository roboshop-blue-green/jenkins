def call() {
  node {
    sh 'rm -rf *'
    stage('Checkout Code') {
      checkout scm
    }
    stage("Terraform") {
      ansiColor('xterm') {
        sh '''
          cd terraform-mutable 
          export TF_VAR_APP_VERSION=$(cat VERSION)
          make dev-apply
        '''
      }
    }
  }
}
