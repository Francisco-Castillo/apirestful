
package com.fcastillo.paisesapi.interfaces;

import javax.ws.rs.core.Response;

public interface Pagination {

    public Response getList(int id, int limit, int offset, String search);

}
