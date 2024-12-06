CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    nickname VARCHAR(50),
    role VARCHAR(20) NOT NULL,
    register_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    login_time TIMESTAMP,
    password VARCHAR(255) NOT NULL,  -- 新增密码字段，加密存储，长度设为适合加密后长度，必填
    personality VARCHAR(100),
    personal_description TEXT,
    birthday DATE,
    phone_number VARCHAR(15),
    email VARCHAR(100),  -- 新增邮箱字段，方便联系及验证等，可为空
    avatar_url VARCHAR(255),  -- 新增头像链接字段，存储用户头像图片的网络地址或本地存储路径，可为空
    is_active BOOLEAN DEFAULT TRUE  -- 新增字段，用于标识用户账号是否处于激活可用状态，默认激活
);

CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,  -- 书名，不允许为空
    author VARCHAR(50) NOT NULL,  -- 作者，不允许为空
    publisher VARCHAR(100),  -- 出版社，可为空
    publication_date DATE,  -- 出版日期，可为空
    isbn VARCHAR(13),  -- 国际标准书号，唯一标识图书，可为空（有些图书可能无ISBN）
    category VARCHAR(50),  -- 图书分类，比如文学、科技等，可为空
    total_copies INT DEFAULT 1,  -- 图书总副本数量，默认1本，用于库存管理
    available_copies INT DEFAULT 1,  -- 可借阅副本数量，初始与总副本数相同，随着借阅归还动态变化
    introduction TEXT  -- 图书简介，详细介绍图书内容，可为空
);

CREATE TABLE borrowing_records (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 借阅时间，默认当前时间
    due_date TIMESTAMP,  -- 应归还时间，根据系统规则设定具体日期，不能为空
    return_date TIMESTAMP,  -- 实际归还时间，初始为空，归还时更新该字段
    FOREIGN KEY (user_id) REFERENCES users(user_id),  -- 外键关联用户表的user_id
    FOREIGN KEY (book_id) REFERENCES books(book_id)  -- 外键关联图书表的book_id
);