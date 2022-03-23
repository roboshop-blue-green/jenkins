def call() {
  node {
    common.prepareArtifacts()
    common.publishArtifacts()
  }
}
