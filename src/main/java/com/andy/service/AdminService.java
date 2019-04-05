package com.andy.service;

import com.andy.model.TourAdmin;

import java.util.List;

public interface AdminService {
    public TourAdmin getUserById(Long id);

    public void insetUser(TourAdmin t);

    public List<TourAdmin> queryAll();
}
