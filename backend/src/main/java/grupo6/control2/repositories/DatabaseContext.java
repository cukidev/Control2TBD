package grupo6.control2.repositories;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import javax.crypto.SecretKey;


@Configuration
public class DatabaseContext {
    @Value("${jdbc.url:jdbc:postgresql://localhost:5432/control}")
    private String url;

    @Value("${database.user:postgres}")
    private String user;

    @Value("${database.pass:password}")
    private String pass;

    @Value("${jwt.secret:Q09MTy1DT0xPIExPIE3DgVMgR1JBTkRFIFBVVEEgUVVFIFRFIFFVSUVSTyBDT0xPIENPTE8gQlVMTEEgV0VDTyBBR1VBTlRFIEVMIElORElPIFBPUiBBVFJBUyBQSUNBIEVMIElORElPIFkgR09MIERFIENBU1pFTFkKQ2FudGVtb3MgdG9kb3MgZGUgYXJpY2EgYSBNYWdhbGxhbmVzClBvciBDb2xvLUNvbG8gZWplbXBsbyBkZSB2YWxvcgpQb3Igc3UgaGlkYWxndcOtYSBubyBoYXkgbmFkaWUgcXVpZW4gbG8gZ2FuZQpQb3JxdWUgZGVmaWVuZGUgY29uIGdsb3JpYSBlbCB0cmljb2xvcgoKRXMgQ29sby1Db2xvIGNvbW8gZWwgZ3JhbiBhcmF1Y2FubwpRdWUgdmEgYSBsYSBsdWNoYSB0ZW5heiBzaW4gZGVzY2Fuc2FyClBvcnF1ZSBlbCByZWN1ZXJkbyBkZSBEYXZpZCBBcmVsbGFubwpTaWVtcHJlIGxvIGd1w61hIHBvciBsYSBzZW5kYSB0cml1bmZhbAoKQ29sby1Db2xvLCBDb2xvLUNvbG8sIGVsIGVxdWlwbyBxdWUgaGEgc2FiaWRvIHNlciBjYW1wZcOzbgpZIGVuIGxhcyBsaWRlcyBkZXBvcnRpdmFzIHBvbmUgc2llbXByZSBzdSBjaGlsZW5vIGNvcmF6w7NuCkNvbG8tQ29sbywgQ29sby1Db2xvLCByZXByZXNlbnRhIG51ZXN0cmEgcmF6YSBzaW4gaWd1YWwKUG9yIHN1IGVtcHVqZSB5IGNvcmFqZSBlbiBsYXMgY2FuY2hhcyBjb21vIGVsIENvbG8tQ29sbyBubyBoYXkKCkVzIENvbG8tQ29sbyB2YWxpZW50ZSwgZnVlcnRlIHkgZ3JhbmRlCkRlIHNhbmdyZSBhbHRpdmEgeSBub2JsZSBjb3JhesOzbgpTdSBub21icmUgdmlicmEgZGVzZGUgZWwgbWFyIGEgbG9zIEFuZGVzClkgaGF5IGVuIHN1cyB0cml1bmZvcyBlc2Z1ZXJ6byB5IGVtb2Npw7NuCgpMYXVyZWxlcyBkZWphIHBvciB0b2RvcyBsb3MgY2FtaW5vcwpRdWUgdmlyaWxtZW50ZSBsdWNoYW5kbyBjb25xdWlzdMOzCkFudG9yY2hhIGlubWVuc2EgZGUgZ2xvcmlhIGVzIHN1IGRlc3Rpbm8KUXVlIGFsdW1icmEgc2llbXByZSBjb24gZnVlZ28gZGUgY2FtcGXDs24KCkNvbG8tQ29sbywgQ29sby1Db2xvLCBlbCBlcXVpcG8gcXVlIGhhIHNhYmlkbyBzZXIgY2FtcGXDs24KWSBlbiBsYXMgbGlkZXMgZGVwb3J0aXZhcyBwb25lIHNpZW1wcmUgc3UgY2hpbGVubyBjb3JhesOzbgpDb2xvLUNvbG8sIENvbG8tQ29sbywgcmVwcmVzZW50YSBudWVzdHJhIHJhemEgc2luIGlndWFsClBvciBzdSBlbXB1amUgeSBjb3JhamUgZW4gbGFzIGNhbmNoYXMgY29tbyBDb2xvLUNvbG8gbm8gaGF5}")
    private String secret;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(url, user, pass);
    }

    @Bean
    public SecretKey secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
