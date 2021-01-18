package com.emp.mgmt.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "modifiedDate"}, allowGetters = true)
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String userPhoto;
    private String status;
    private UserContact userContact;
    private UserPassword userPassword;
    private Integer createdByUserId;
    private Integer modifiedByUserId;
    private Date createdDate;
    private Date modifiedDate;


    public User()
    {
        super();
    }


    public User(
        Integer userId, String userName, String firstName, String lastName, String userPhoto, String status, UserContact userContact, UserPassword userPassword,
        Integer createdByUserId, Integer modifiedByUserId)
    {
        super();
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPhoto = userPhoto;
        this.status = status;
        this.userContact = userContact;
        this.userPassword = userPassword;
        this.createdByUserId = createdByUserId;
        this.modifiedByUserId = modifiedByUserId;
    }


    public User(
        Integer userId, String userName, String firstName, String lastName, String userPhoto, String status, UserContact userContact, UserPassword userPassword,
        Integer createdByUserId, Integer modifiedByUserId, Date createdDate, Date modifiedDate)
    {
        super();
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPhoto = userPhoto;
        this.status = status;
        this.userContact = userContact;
        this.userPassword = userPassword;
        this.createdByUserId = createdByUserId;
        this.modifiedByUserId = modifiedByUserId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    public Integer getUserId()
    {
        return userId;
    }


    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }


    @Column(length = 100, unique = true, nullable = false, updatable = false)
    public String getUserName()
    {
        return userName;
    }


    public void setUserName(String userName)
    {
        this.userName = userName;
    }


    @Column(length = 100, nullable = false)
    public String getFirstName()
    {
        return firstName;
    }


    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    @Column(length = 100, nullable = false)
    public String getLastName()
    {
        return lastName;
    }


    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    @Column(length = 100)
    public String getUserPhoto()
    {
        return userPhoto;
    }


    public void setUserPhoto(String userPhoto)
    {
        this.userPhoto = userPhoto;
    }


    @Column(length = 20, nullable = false)
    public String getStatus()
    {
        return status;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    public UserContact getUserContact()
    {
        return userContact;
    }


    public void setUserContact(UserContact userContact)
    {
        this.userContact = userContact;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id")
    public UserPassword getUserPassword()
    {
        return userPassword;
    }


    public void setUserPassword(UserPassword userPassword)
    {
        this.userPassword = userPassword;
    }


    @Column(nullable = false)
    public Integer getCreatedByUserId()
    {
        return createdByUserId;
    }


    public void setCreatedByUserId(Integer createdByUserId)
    {
        this.createdByUserId = createdByUserId;
    }


    @Column(nullable = false)
    public Integer getModifiedByUserId()
    {
        return modifiedByUserId;
    }


    public void setModifiedByUserId(Integer modifiedByUserId)
    {
        this.modifiedByUserId = modifiedByUserId;
    }


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getCreatedDate()
    {
        return createdDate;
    }


    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getModifiedDate()
    {
        return modifiedDate;
    }


    public void setModifiedDate(Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }


    @Override
    public String toString()
    {
        return "User [userId="
            + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", userPhoto=" + userPhoto + ", status=" + status + ", userContact="
            + userContact + ", userPassword=" + userPassword + ", createdByUserId=" + createdByUserId + ", modifiedByUserId=" + modifiedByUserId + ", createdDate=" + createdDate
            + ", modifiedDate=" + modifiedDate + "]";
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdByUserId == null) ? 0 : createdByUserId.hashCode());
        result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((modifiedByUserId == null) ? 0 : modifiedByUserId.hashCode());
        result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((userContact == null) ? 0 : userContact.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
        result = prime * result + ((userPhoto == null) ? 0 : userPhoto.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (createdByUserId == null)
        {
            if (other.createdByUserId != null)
                return false;
        }
        else if (!createdByUserId.equals(other.createdByUserId))
            return false;
        if (createdDate == null)
        {
            if (other.createdDate != null)
                return false;
        }
        else if (!createdDate.equals(other.createdDate))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (modifiedByUserId == null)
        {
            if (other.modifiedByUserId != null)
                return false;
        }
        else if (!modifiedByUserId.equals(other.modifiedByUserId))
            return false;
        if (modifiedDate == null)
        {
            if (other.modifiedDate != null)
                return false;
        }
        else if (!modifiedDate.equals(other.modifiedDate))
            return false;
        if (status == null)
        {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
            return false;
        if (userContact == null)
        {
            if (other.userContact != null)
                return false;
        }
        else if (!userContact.equals(other.userContact))
            return false;
        if (userId == null)
        {
            if (other.userId != null)
                return false;
        }
        else if (!userId.equals(other.userId))
            return false;
        if (userName == null)
        {
            if (other.userName != null)
                return false;
        }
        else if (!userName.equals(other.userName))
            return false;
        if (userPassword == null)
        {
            if (other.userPassword != null)
                return false;
        }
        else if (!userPassword.equals(other.userPassword))
            return false;
        if (userPhoto == null)
        {
            if (other.userPhoto != null)
                return false;
        }
        else if (!userPhoto.equals(other.userPhoto))
            return false;
        return true;
    }

}
