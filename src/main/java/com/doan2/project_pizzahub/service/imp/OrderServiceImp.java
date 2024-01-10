package com.doan2.project_pizzahub.service.imp;

import com.doan2.project_pizzahub.payload.request.OrderRequest;

public interface OrderServiceImp {
    boolean insertOrder(OrderRequest orderRequest);
}
