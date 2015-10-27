/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.model;

import java.io.Serializable;

public class AppUser implements Serializable {
    /**
     * <pre>
     * 主键
     * 表字段 : app_user.id
     * </pre>
     */
    private Long id;

    /**
     * <pre>
     * 是否过期
     * 表字段 : app_user.account_expired
     * </pre>
     */
    private Boolean accountExpired;

    /**
     * <pre>
     * 是否锁定
     * 表字段 : app_user.account_locked
     * </pre>
     */
    private Boolean accountLocked;

    /**
     * <pre>
     * 
     * 表字段 : app_user.address
     * </pre>
     */
    private String address;

    /**
     * <pre>
     * 
     * 表字段 : app_user.city
     * </pre>
     */
    private String city;

    /**
     * <pre>
     * 
     * 表字段 : app_user.country
     * </pre>
     */
    private String country;

    /**
     * <pre>
     * 
     * 表字段 : app_user.postal_code
     * </pre>
     */
    private String postalCode;

    /**
     * <pre>
     * 
     * 表字段 : app_user.province
     * </pre>
     */
    private String province;

    /**
     * <pre>
     * 
     * 表字段 : app_user.credentials_expired
     * </pre>
     */
    private Boolean credentialsExpired;

    /**
     * <pre>
     * 
     * 表字段 : app_user.email
     * </pre>
     */
    private String email;

    /**
     * <pre>
     * 
     * 表字段 : app_user.account_enabled
     * </pre>
     */
    private Boolean accountEnabled;

    /**
     * <pre>
     * 
     * 表字段 : app_user.first_name
     * </pre>
     */
    private String firstName;

    /**
     * <pre>
     * 
     * 表字段 : app_user.last_name
     * </pre>
     */
    private String lastName;

    /**
     * <pre>
     * 
     * 表字段 : app_user.password
     * </pre>
     */
    private String password;

    /**
     * <pre>
     * 
     * 表字段 : app_user.password_hint
     * </pre>
     */
    private String passwordHint;

    /**
     * <pre>
     * 
     * 表字段 : app_user.phone_number
     * </pre>
     */
    private String phoneNumber;

    /**
     * <pre>
     * 
     * 表字段 : app_user.username
     * </pre>
     */
    private String username;

    /**
     * <pre>
     * 
     * 表字段 : app_user.version
     * </pre>
     */
    private Integer version;

    /**
     * <pre>
     * 
     * 表字段 : app_user.website
     * </pre>
     */
    private String website;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：主键
     * 表字段：app_user.id
     * </pre>
     *
     * @return app_user.id：主键
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键
     * 表字段：app_user.id
     * </pre>
     *
     * @param id
     *            app_user.id：主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：是否过期
     * 表字段：app_user.account_expired
     * </pre>
     *
     * @return app_user.account_expired：是否过期
     */
    public Boolean getAccountExpired() {
        return accountExpired;
    }

    /**
     * <pre>
     * 设置：是否过期
     * 表字段：app_user.account_expired
     * </pre>
     *
     * @param accountExpired
     *            app_user.account_expired：是否过期
     */
    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    /**
     * <pre>
     * 获取：是否锁定
     * 表字段：app_user.account_locked
     * </pre>
     *
     * @return app_user.account_locked：是否锁定
     */
    public Boolean getAccountLocked() {
        return accountLocked;
    }

    /**
     * <pre>
     * 设置：是否锁定
     * 表字段：app_user.account_locked
     * </pre>
     *
     * @param accountLocked
     *            app_user.account_locked：是否锁定
     */
    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.address
     * </pre>
     *
     * @return app_user.address：
     */
    public String getAddress() {
        return address;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.address
     * </pre>
     *
     * @param address
     *            app_user.address：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.city
     * </pre>
     *
     * @return app_user.city：
     */
    public String getCity() {
        return city;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.city
     * </pre>
     *
     * @param city
     *            app_user.city：
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.country
     * </pre>
     *
     * @return app_user.country：
     */
    public String getCountry() {
        return country;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.country
     * </pre>
     *
     * @param country
     *            app_user.country：
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.postal_code
     * </pre>
     *
     * @return app_user.postal_code：
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.postal_code
     * </pre>
     *
     * @param postalCode
     *            app_user.postal_code：
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.province
     * </pre>
     *
     * @return app_user.province：
     */
    public String getProvince() {
        return province;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.province
     * </pre>
     *
     * @param province
     *            app_user.province：
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.credentials_expired
     * </pre>
     *
     * @return app_user.credentials_expired：
     */
    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.credentials_expired
     * </pre>
     *
     * @param credentialsExpired
     *            app_user.credentials_expired：
     */
    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.email
     * </pre>
     *
     * @return app_user.email：
     */
    public String getEmail() {
        return email;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.email
     * </pre>
     *
     * @param email
     *            app_user.email：
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.account_enabled
     * </pre>
     *
     * @return app_user.account_enabled：
     */
    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.account_enabled
     * </pre>
     *
     * @param accountEnabled
     *            app_user.account_enabled：
     */
    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.first_name
     * </pre>
     *
     * @return app_user.first_name：
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.first_name
     * </pre>
     *
     * @param firstName
     *            app_user.first_name：
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.last_name
     * </pre>
     *
     * @return app_user.last_name：
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.last_name
     * </pre>
     *
     * @param lastName
     *            app_user.last_name：
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.password
     * </pre>
     *
     * @return app_user.password：
     */
    public String getPassword() {
        return password;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.password
     * </pre>
     *
     * @param password
     *            app_user.password：
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.password_hint
     * </pre>
     *
     * @return app_user.password_hint：
     */
    public String getPasswordHint() {
        return passwordHint;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.password_hint
     * </pre>
     *
     * @param passwordHint
     *            app_user.password_hint：
     */
    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.phone_number
     * </pre>
     *
     * @return app_user.phone_number：
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.phone_number
     * </pre>
     *
     * @param phoneNumber
     *            app_user.phone_number：
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.username
     * </pre>
     *
     * @return app_user.username：
     */
    public String getUsername() {
        return username;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.username
     * </pre>
     *
     * @param username
     *            app_user.username：
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.version
     * </pre>
     *
     * @return app_user.version：
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.version
     * </pre>
     *
     * @param version
     *            app_user.version：
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：app_user.website
     * </pre>
     *
     * @return app_user.website：
     */
    public String getWebsite() {
        return website;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：app_user.website
     * </pre>
     *
     * @param website
     *            app_user.website：
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountExpired=").append(accountExpired);
        sb.append(", accountLocked=").append(accountLocked);
        sb.append(", address=").append(address);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", province=").append(province);
        sb.append(", credentialsExpired=").append(credentialsExpired);
        sb.append(", email=").append(email);
        sb.append(", accountEnabled=").append(accountEnabled);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", password=").append(password);
        sb.append(", passwordHint=").append(passwordHint);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", username=").append(username);
        sb.append(", version=").append(version);
        sb.append(", website=").append(website);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountEnabled == null) ? 0 : accountEnabled.hashCode());
        result = prime * result + ((accountExpired == null) ? 0 : accountExpired.hashCode());
        result = prime * result + ((accountLocked == null) ? 0 : accountLocked.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((credentialsExpired == null) ? 0 : credentialsExpired.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((passwordHint == null) ? 0 : passwordHint.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((province == null) ? 0 : province.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((website == null) ? 0 : website.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppUser other = (AppUser) obj;
        if (accountEnabled == null) {
            if (other.accountEnabled != null)
                return false;
        } else if (!accountEnabled.equals(other.accountEnabled))
            return false;
        if (accountExpired == null) {
            if (other.accountExpired != null)
                return false;
        } else if (!accountExpired.equals(other.accountExpired))
            return false;
        if (accountLocked == null) {
            if (other.accountLocked != null)
                return false;
        } else if (!accountLocked.equals(other.accountLocked))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (credentialsExpired == null) {
            if (other.credentialsExpired != null)
                return false;
        } else if (!credentialsExpired.equals(other.credentialsExpired))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (passwordHint == null) {
            if (other.passwordHint != null)
                return false;
        } else if (!passwordHint.equals(other.passwordHint))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (province == null) {
            if (other.province != null)
                return false;
        } else if (!province.equals(other.province))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        if (website == null) {
            if (other.website != null)
                return false;
        } else if (!website.equals(other.website))
            return false;
        return true;
    }
}