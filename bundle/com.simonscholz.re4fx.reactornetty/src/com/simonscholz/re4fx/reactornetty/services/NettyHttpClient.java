package com.simonscholz.re4fx.reactornetty.services;

import java.io.IOException;
import java.io.InputStream;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simonscholz.re4fx.common.services.ReactorHttpClient;

import reactor.core.Exceptions;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Component
public class NettyHttpClient implements ReactorHttpClient {

	private HttpClient client;
	private ObjectMapper om;

	public NettyHttpClient() {
		client = HttpClient.create(ConnectionProvider.elastic("Elastic-ConnectionProvider"));
		om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public <T> Mono<T> get(String url, Class<T> responseType) {
		return client.headers(hb -> {
			hb.add("Accept", "application/json");
		}).get().uri(url).responseSingle((response, byteMono) -> {
			Mono<InputStream> ism = byteMono.asInputStream();

			return ism.map(is -> {
				try {
					return om.readValue(is, responseType);
				} catch (IOException e) {
					throw Exceptions.propagate(e);
				}
			});
		});
	}

	@Override
	public <T> Mono<T> get(String url, TypeReference<T> responseType) {
		return client.headers(hb -> {
			hb.add("Accept", "application/json");
		}).get().uri(url).responseSingle((response, byteMono) -> {
			Mono<InputStream> ism = byteMono.asInputStream();

			return ism.map(is -> {
				try {
					return om.readValue(is, responseType);
				} catch (IOException e) {
					throw Exceptions.propagate(e);
				}
			});
		});
	}

	@Override
	public <T> Mono<T> post(String url, Object body, Class<T> responseType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Mono<T> put(String url, Object body, Class<T> responseType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Mono<T> delete(String url, Object body, Class<T> responseType) {
		// TODO Auto-generated method stub
		return null;
	}

}
