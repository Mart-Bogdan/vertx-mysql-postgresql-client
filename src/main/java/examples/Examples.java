/*
 *  Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package examples;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.asyncsql.PostgreSQLClient;
import io.vertx.ext.sql.SQLConnection;

/**
  *
  * @author <a href="http://tfox.org">Tim Fox</a>
  */
public class Examples {

  public void exampleCreateDefault(Vertx vertx) {

    // To create a MySQL client:

    JsonObject mySQLClientConfig = new JsonObject().put("host", "mymysqldb.mycompany");
    AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig);

    // To create a PostgreSQL client:

    JsonObject postgreSQLClientConfig = new JsonObject().put("host", "mypostgresqldb.mycompany");
    AsyncSQLClient postgreSQLClient = PostgreSQLClient.createShared(vertx, postgreSQLClientConfig);

  }

  public void exampleCreatePoolName(Vertx vertx) {

    // To create a MySQL client:

    JsonObject mySQLClientConfig = new JsonObject().put("host", "mymysqldb.mycompany");
    AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig, "MySQLPool1");

    // To create a PostgreSQL client:

    JsonObject postgreSQLClientConfig = new JsonObject().put("host", "mypostgresqldb.mycompany");
    AsyncSQLClient postgreSQLClient = PostgreSQLClient.createShared(vertx, postgreSQLClientConfig, "PostgreSQLPool1");

  }

  public void exampleCreateNonShared(Vertx vertx) {

    // To create a MySQL client:

    JsonObject mySQLClientConfig = new JsonObject().put("host", "mymysqldb.mycompany");
    AsyncSQLClient mySQLClient = MySQLClient.createNonShared(vertx, mySQLClientConfig);

    // To create a PostgreSQL client:

    JsonObject postgreSQLClientConfig = new JsonObject().put("host", "mypostgresqldb.mycompany");
    AsyncSQLClient postgreSQLClient = PostgreSQLClient.createNonShared(vertx, postgreSQLClientConfig);

  }

  public void example2(Vertx vertx) {

    JsonObject config = new JsonObject().put("host", "mymysqldb.mycompany");

    AsyncSQLClient mySQLClient = MySQLClient.createNonShared(vertx, config);

  }

  public void example3(Vertx vertx) {

    JsonObject config = new JsonObject().put("host", "mypostgresqldb.mycompany");

    AsyncSQLClient postgreSQLClient = PostgreSQLClient.createNonShared(vertx, config);
  }

  public void example4(AsyncSQLClient client) {

    // Now do stuff with it:

    client.getConnection(res -> {
      if (res.succeeded()) {

        SQLConnection connection = res.result();

        // Got a connection

      } else {
        // Failed to get connection - deal with it
      }
    });

  }


}
