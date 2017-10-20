package com.makinduempire.devlauncher.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Makindu ExpressC on 12/04/2017.
 */
@Table(name = "basic_users")
public class User extends Model{

    @Column(name = "username")
    public String username;


}
