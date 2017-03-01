package main.scala

import main.scala.TestBrute._

/**
  * Created by sstolyarenko on 01.03.2017.
  */
class BrutePass {
  
  val logHash = Set(
    ("avatar",
      "b8b1ebd89ebd4a5c29636c4e55cab380e5b08ee71247adf11baa5386966cf676de81ef48c0aed5205d6a0d6a6ec2d0ab215dedc89eeb41f5bf71957c0eb09397"),
    ("atlanovna",
      "42a8582774c5dde96b23f4d777c12bec26d2ca3499891dd71182a50c0291f3c082abbca4581a3efe57e8976e68c831803168147a9a43688aee05922782ec2485"),
    ("test_user",
      "ee6372abdd80700b0eb0fb8bdb2fc0fc94b0d526d17d49a0d86752c2c6b24fb1c7cac19630841ac05451e5b6917f0b06889ff14497344666e6d77cf045d3e68d"),
    ("front",
      "78fb4b3eb03dd5aa4c292e446a99f984ca44e2d679c380f496d4667cb53e13f11e0b267f58bc8f8dd59ec7073f2d5ac4edfd41fd0efdb4175f4427abb988df45"),
    ("eruban",
      "98ee558c34324acec1eaca6aa95218efa831c1ae1732a73450be66a8909d0ec9885e1b0f712e5e751702412ac62ec169baeb7f0dac06766617f6eb2481bb8965"),
    ("juniormailer",
      "898944fab951c79ed16a757b2c40cdf51bf4fe99579c1748a315894cf71630c401ce1d9bb79f18b9c4aa774030b7d06f05b449b727ef4095b1ffe4f0ba4183d4"),
    ("tn3eub89xu",
      "fc8c900c5b3ad2f780ad4fe7b64436d1318c94085952f91a8751a09eb292aaaf36e6c01a97bcac44d7a04fd9088c73f2af474f6056cbcaf9615cfb28ba5ccd7b"))
  
  val password = "qwerty1!"
  val login = "avatar"
  val input = password + login
  val calcHash = md.digest(input.getBytes)
  
  val pass = bruteHash(calcHash, login, password)
  println(s"Pass $pass")
  
}
