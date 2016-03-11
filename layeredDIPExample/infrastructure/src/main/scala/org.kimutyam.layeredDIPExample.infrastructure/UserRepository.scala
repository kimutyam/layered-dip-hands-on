package org.kimutyam.layeredDIPExample.infrastructure

import org.kimutyam.layeredDIPExample.domain.UserRepository

class UserRepositoryOnRDBMS
  extends UserRepository {
  //略
}

class UserRepositoryOnAPI
  extends UserRepository {
  //略
}

class UserRepositoryOnKVS
  extends UserRepository {
  //略
}
