def call(int buildNumber) {
  pipeline {

    agent any

      stages {

        stage('Prepare Artifacts') {
          steps {
            sh '''
              echo 
            '''
          }
        }

        stage('Publish Artifacts') {
          steps {
            sh '''
              echo 
            '''
          }
        }


      }
    }

}
