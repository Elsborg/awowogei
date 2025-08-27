package com.martinelsborg.awowogei.config;

import java.io.IOException;
import java.time.Duration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class RateLimitFilter implements Filter {
    private final Bucket bucket;

    public RateLimitFilter() {
        Bandwidth limit = Bandwidth.simple(10, Duration.ofSeconds(10));
        this.bucket = Bucket.builder().addLimit(limit).build();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (bucket.tryConsume(1)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResp = (HttpServletResponse) response;
            httpResp.setStatus(429);
            httpResp.getWriter().write("Too many requests, slow down!");
        }
    }
}
