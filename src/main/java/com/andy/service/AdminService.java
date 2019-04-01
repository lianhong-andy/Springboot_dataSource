package com.andy.service;

import com.andy.model.TourAdmin;

public interface AdminService {
    public TourAdmin getUserById(Long id);

    public void insetUser(TourAdmin t);
}
