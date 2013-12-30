package br.com.willianantunes.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.willianantunes.model.User;
import br.com.willianantunes.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository 
{

}
