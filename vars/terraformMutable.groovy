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
          make dev-apply
        '''
      }
    }
  }
}
