package com.github.dreamhead.moco.handler;

import com.github.dreamhead.moco.MocoConfig;
import com.github.dreamhead.moco.ResponseHandler;
import com.github.dreamhead.moco.resource.Resource;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpVersion;

public class VersionResponseHandler implements ResponseHandler {
    private final Resource resource;

    public VersionResponseHandler(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void writeToResponse(HttpRequest request, HttpResponse response) {
        HttpVersion httpVersion = HttpVersion.valueOf(new String(resource.readFor(request)));
        response.setProtocolVersion(httpVersion);
    }

    @Override
    public ResponseHandler apply(final MocoConfig config) {
        return this;
    }
}
