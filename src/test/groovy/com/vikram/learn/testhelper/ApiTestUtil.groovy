package com.vikram.learn.testhelper

import groovyx.net.http.EncoderRegistry
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.apache.cxf.helpers.IOUtils
import org.apache.cxf.jaxrs.client.WebClient
import org.apache.cxf.jaxrs.ext.multipart.Attachment
import org.apache.cxf.jaxrs.ext.multipart.AttachmentBuilder
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody
import org.codehaus.groovy.runtime.MethodClosure

import javax.ws.rs.core.Cookie
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.UriBuilder

import static groovy.json.JsonOutput.toJson
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.POST
class ApiTestUtil {
    private static final String baseUrl = 'http://localhost:8082/'

    static Map get(String url){
        Map response = [:]
        def client = new RESTClient("${baseUrl}")
        try {
            client.get(path: url, requestContentType: JSON) { res, data ->
                response.statusCode = res.status
                response.body = data
            }
        }
        catch (HttpResponseException ex) {
            response.statusCode = ex.response.status
            response.body = ex.response.data
        }
        response
    }
}
