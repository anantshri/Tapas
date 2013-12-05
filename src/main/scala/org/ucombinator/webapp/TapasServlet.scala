package org.ucombinator.webapp

import org.scalatra._
import scalate.ScalateSupport
import scala.slick.session.Database

import org.ucombinator.webapp.auth.AuthenticationSupport

class TapasServlet(val db: Database) extends TapasWebAppStack with AuthenticationSupport {

  before() {
    db withSession {
      requireLogin()
    }
  }

  get("/") {
    <html>
      <head>
        <title>Tapas Web App</title>
      </head>
      <body>
        <h1>Welcome to the Tapas Web App!</h1>
        <p>Eventually there will be an application here.</p>
      </body>
    </html>
  }
}
