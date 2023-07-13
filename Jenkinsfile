pipeline {
  agent any
  stages {
    stage('Git repo clone')
    {
      steps{
         echo "cloned from git repo"
      }
    }
    stage('Build') {
      steps{
          echo "running maven install command"
          bat 'mvn clean install -DskipTests'
      }
    }
    stage('deploy into tomcat') {
      steps{
        echo "Deploying war file into tomcat ..."
        bat 'mvn tomcat6:deploy'
      }
    }
  }
  post
  {
    failure{
      echo "build failed"
    }
  }
}