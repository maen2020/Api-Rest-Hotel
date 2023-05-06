package com.maen.hotel.mapper;

public interface IUserMapper <I, O> {
    public O map(I in);
}
