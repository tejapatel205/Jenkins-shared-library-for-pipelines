def call(Map config = [:]) {
    def branch = config.branch ?: 'main'
    def url = config.url ?: env.GIT_URL
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[url: url, credentialsId: config.credentialsId ?: 'git-creds']],
        extensions: [[$class: 'SubmoduleOption', recursiveSubmodules: true]]
    ])
}