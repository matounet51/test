// include the Themeparks library
const Themeparks = require("themeparks");

// configure where SQLite DB sits
// optional - will be created in node working directory if not configured
// Themeparks.Settings.Cache = __dirname + "/themeparks.db";

// access a specific park
//  Create this *ONCE* and re-use this object for the lifetime of your application
//  re-creating this every time you require access is very slow, and will fetch data repeatedly for no purpose
const DisneyWorldMagicKingdom = new Themeparks.Parks.DisneylandParisMagicKingdom();

// Access wait times by Promise
DisneyWorldMagicKingdom.GetWaitTimes().then((rideTimes) => {
    for(var i=0, ride; ride=rideTimes[i++];) {
        console.log(`${ride.name}: ${ride.waitTime}' --  (${ride.status}) -- ${ride.lastUpdate}`);
    }
}).catch((error) => {
    console.error(error);
});

