def call() {
  node {
    sh 'rm -rf *'
    stage('Checkout Code') {
      checkout scm
    }
    stage("Terraform") {
      sh '''
        cd terraform-mutable 
        make dev-apply
      '''
    }
  }
}
