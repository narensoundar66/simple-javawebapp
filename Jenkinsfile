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
    stage('Build') {
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

      stage('open chrome to display webpage') {
                  steps{
                    echo "opening chrome to display site"
                            bat 'chromedriver --port=4444 --url-base=/wd/hub'

                            script {
                                        def driver = new ChromeDriver()
                                        driver.get("http://localhost:8081/simple/")
                                    }
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
 }