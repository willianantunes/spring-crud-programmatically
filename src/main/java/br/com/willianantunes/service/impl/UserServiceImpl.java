package br.com.willianantunes.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.willianantunes.model.User;
import br.com.willianantunes.repository.UserRepository;
import br.com.willianantunes.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User t) 
	{
		userRepository.save(t);	
	}

	@Override
	public User find(Long id) 
	{
		return userRepository.find(id);
	}

	@Override
	public Collection<User> findTheRange(int start, int length) 
	{
		return userRepository.findTheRange(start, length);
	}

	@Override
	public Collection<User> list() 
	{
		return userRepository.list();
	}

	@Override
	public void saveOrUpdate(User t) 
	{
		userRepository.saveOrUpdate(t);
	}

	@Override
	public User merge(User t) 
	{
		return userRepository.merge(t);
	}

	@Override
	public void remove(User t) 
	{
		userRepository.remove(t);
		
	}

	@Override
	public void update(User t) 
	{
		userRepository.update(t);
	}

	@Override
	public Long totalRecords(String column) 
	{
		return userRepository.totalRecords(column);
	}
}
