package com.muran.api.service;

import javax.ws.rs.core.Response;

import com.muran.api.Context;

public interface IKeywordsService  {
	Response getKeywords(String columnKey,Context context);
}
