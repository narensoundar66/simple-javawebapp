@Library("narenshared") _
def value1 = "hi"
pipeline
{
  agent any
  stages {
    stage('Git repo clone')
    {
      steps{
         echo "cloned from git repo"
      }
    }
    stage('shared-library')
    {
    steps
    {

       buildNaren(value1)
    }
    }
   /* stage('Build') {
      steps{
          echo "running maven install command"
          bat 'mvn clean package -DskipTests'
      }
    }
    stage('deploy into tomcat') {
      steps{
        echo "Deploying war file into tomcat ..."
        bat 'mvn install tomcat6:deploy -DskipTests'
      }
    }

  }
     post
     {
            always
            {
                cleanWs(cleanWhenNotBuilt: false,
                        deleteDirs: true,
                        disableDeferredWipeout: true,
                        notFailBuild: true,
                        patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                                   [pattern: '.propsfile', type: 'EXCLUDE']])
            }
    }
  */
 }
 }