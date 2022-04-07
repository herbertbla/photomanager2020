// eslint-disable-next-line @typescript-eslint/no-var-requires
var express = require('express');
var cors = require('cors');
// eslint-disable-next-line @typescript-eslint/no-unsafe-call
var app = express();
var port = process.env.PORT || 3000;
app.use(cors());

// eslint-disable-next-line @typescript-eslint/no-unsafe-call
app.listen(port);

console.log('RESTful API server started on: ' + port);

app.get('/at.gv.justiz.local2.svpersonenbeziehungen-ui/svpersonenbeziehungen-ui/api/ui/config', function(req, res) {
  res.end(JSON.stringify({"uiExceptionHandlerLoggingActive":"true","ju30WpsUrls":"wss://jus3wps01.jint.local/at.gv.justiz.qsys.wps/","userLabel":"Jasmin Brakmic","uiLoggingInterval":"5","uiLogLevel":"debug","versionString":"Aktensystem (aktensystem-qqsys-bax) 3.14.23, Platform 3.0.80","httpLoggingActive":"true","bkuSignaturUrl":"http://localhost:4560/at.gv.justiz.prod.bkusignatur/","justizServiceId":"as","deviceName":"","uploadMaxFileSize":"52428800","justizServiceLabel":"Aktensystem","uiLoggingActive":"true","httpLoggingFallbackActive":"false","wpsBrokerEnabled":"true","asWpsEnabled":"true","jufiEnabled":"false","userEmail":"jasmin.brakmic@accenture.com","applicationId":"as-qqs@justiz.gv.at","userKennung":"AT:BMJ:uwbpondxi"}));
});
app.get('/at.gv.justiz.local2.jufi/api/ui/getallregisteredapplikationinfos4user', function(req, res) {
  res.end(JSON.stringify([{"anwendungCode":"evm-bv-qs@justiz.gv.at","anwendungsVersion":"4.2.2","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/4.2.2/evm-bv-qs@justiz.gv.at"},{"anwendungCode":"vollbetreu-qs@justiz.gv.at","anwendungsVersion":"5.3.2","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/5.3.2/vollbetreu-qs@justiz.gv.at"},{"anwendungCode":"tm-qs@justiz.gv.at","anwendungsVersion":"10.17.1","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/10.17.1/tm-qs@justiz.gv.at"},{"anwendungCode":"as-qs@justiz.gv.at","anwendungsVersion":"3.14.33","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/3.14.33/as-qs@justiz.gv.at"},{"anwendungCode":"evm-pbz-qs@justiz.gv.at","anwendungsVersion":"0.1.1-SNAPSHOT","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/0.1.1-SNAPSHOT/evm-pbz-qs@justiz.gv.at"},{"anwendungCode":"evm-bet-qs@justiz.gv.at","anwendungsVersion":"3.2.3","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/3.2.3/evm-bet-qs@justiz.gv.at"},{"anwendungCode":"evm-kla-qs@justiz.gv.at","anwendungsVersion":"3.3.4","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/3.3.4/evm-kla-qs@justiz.gv.at"},{"anwendungCode":"evm-breg-qs@justiz.gv.at","anwendungsVersion":"3.2.1","configDataLink":"https://stp-intern-q.justiz.cal.local/at.gv.justiz.qsys.jufi/resource/getResourceAsJS/3.2.1/evm-breg-qs@justiz.gv.at"}]));
});
app.get('/at.gv.justiz.local2.jufi/api/ui/getcurrentuseranwendungsrollenrechte', function(req, res) {
  res.end(JSON.stringify(["BET_SUPPORT","SVSUPPORT","KLA_SUPPORT","SVSUPPORT","PBZ_BEARB","PBZ_LESEN","SVSUPPORT","EUEHA_BEARB","EUEHA_LESEN","EUEHA_SUPPORT","SVSUPPORT","BREG_SUPPORT","SVSUPPORT","ORGDATEN_ABFRAGEN","SVSUPPORT","BILDER_SUPPORT","SVSUPPORT","AKT_LESEN","SVSUPPORT","PROZESS_STARTEN","SVSUPPORT"]));
});
// eslint-disable-next-line @typescript-eslint/no-unsafe-call
app.get('/at.gv.justiz.management.configserver/svpersonenbeziehungen-ui/local2', function(req, res) {
// eslint-disable-next-line @typescript-eslint/no-unsafe-call
  res.end(JSON.stringify({
    name: 'svpersonenbeziehungen-ui',
    profiles: [
      'local2'
    ],
    label: null,
    version: 'cbd9413ce7c80e471bd17a77345f444a461418a4',
    state: null,
    propertySources: [
      {
        source: {
          'ods.url': 'http://localhost:8000/at.gv.justiz.local2.ods/',
          'ods.url.external': 'http://localhost:8000/at.gv.justiz.local2.ods/',
          'aktensystem.url': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-ui.url': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-ui.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-pdf.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem-pdf/',
          'svpersonenbeziehungen-ui.url': 'http://localhost:8000/at.gv.justiz.local2.svpersonenbeziehungen/',
          'svpersonenbeziehungen-ui.url.external': 'http://localhost:8000/at.gv.justiz.local2.svpersonenbeziehungen/',
          'eingabesystem.url': 'http://localhost:8000/at.gv.justiz.local2.eingabesystem/',
          'eingabesystem.url.external': 'http://localhost:8000/at.gv.justiz.local2.eingabesystem/',
          'rore.url': 'http://localhost:8000/at.gv.justiz.local2.rore/',
          'rore.url.external': 'http://localhost:8000/at.gv.justiz.local2.rore/',
          'kalender.url': 'http://localhost:8000/at.gv.justiz.local2.kalender/',
          'kalender.url.external': 'http://localhost:8000/at.gv.justiz.local2.kalender/',
          'workflow.url': 'http://localhost:8000/at.gv.justiz.local2.workflow/',
          'workflow.url.external': 'http://localhost:8000/at.gv.justiz.local2.workflow/',
          'anwenderinfo.url': 'http://localhost:8000/at.gv.justiz.local2.anwenderinfo/',
          'anwenderinfo.url.external': 'http://localhost:8000/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass-0': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass-1': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'ztc.url.external': 'http://localhost:8000/at.gv.justiz.local2.ztc-core/',
          'uss.url.external': 'http://localhost:8000/at.gv.justiz.local2.ussservice/',
          'vws.url': 'http://localhost:8000/at.gv.justiz.local2.vws/',
          'vws.url.external': 'http://localhost:8000/at.gv.justiz.local2.vws/',
          'vws-cli.url': 'http://localhost:8000/at.gv.justiz.local2.vws-cli/',
          'vws-cli.url.external': 'http://localhost:8000/at.gv.justiz.local2.vws-cli/',
          'jufi.url.external': 'http://localhost:4200/at.gv.justiz.local2.jufi/',
          'zipkin.enabled': 'true',
          'zipkin.server.url': 'http://localhost:9411',
          'zipkin.logtoconsole': 'false',
          'zipkin.sampler.random': '1',
          'zipkin.sampler.counting': 'null'
        }
      }
    ]
  }));
});
