don't read 15 
vertical center of quote boxes. 'style: table-cell' display:table-cell  <div style='display:table-cell'>

Probably ought to expand the points here into more slides, since it's the crux.
Can't verify config is good without running app
Mixed app logic and config loading
Config errors are reported late and badly (Exception points back at the code not the config.)

Verified at Compile-time (partially)

Use an Optional on and a default value for shinier config

Illustrate how we'd then run the VerifyConfigMain
java -cp awesome.jar:. VerifyConfigMain
