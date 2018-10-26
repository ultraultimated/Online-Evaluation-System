
/*
 * CategoryRepository
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryRepository
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/26/2018
 */
package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Category interface Repository provides access to database by using
 * spring-data-JPA
 * This interface implements CRUDrepository to provide basic functionality of
 * creating, retrieving, updating and deleting.
 *
 * @author Neel Parikh
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer>
{

}
