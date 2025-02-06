-- CREATE DATABASE
create database evolveu;
show databases;

use evolveu;
show tables;

-- TO VIEW AVAILABLE COLUMNS FROM ALL AVAILABLE TABLES
SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'evolveu';

-- MAIN TABLE
SELECT * FROM MAIN;
CREATE TABLE MAIN(
    RoleId INT PRIMARY KEY,
    RoleName ENUM("Learner","Admin","Instructor"),
    Description TEXT,
    CreatedAt TIMESTAMP,
    UpdatedAt TIMESTAMP
);
ALTER TABLE MAIN MODIFY COLUMN CreatedAt TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE MAIN MODIFY COLUMN UpdatedAt TIMESTAMP DEFAULT current_timestamp;

-- ADMIN TABLE
SELECT * FROM Admin;
ALTER TABLE Admin ADD COLUMN Updated_at TIMESTAMP;
ALTER TABLE Admin ADD COLUMN Created_at TIMESTAMP;
CREATE TABLE Admin (
    AdminId INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    EmailId VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    UserId INT,
    InstructorId INT,
    CourseId INT,
    reportId INT,
    paymentId INT,
    rfId INT,
    FOREIGN KEY (UserId) REFERENCES Learners(Userid),
    FOREIGN KEY (InstructorId) REFERENCES Instructor(InstructorId),
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
    FOREIGN KEY (reportId) REFERENCES Reports(reportId),
    FOREIGN KEY (paymentId) REFERENCES Payments(paymentId),
    FOREIGN KEY (rfId) REFERENCES Rating_Feedback(rfId)
);

-- LEARNERS TABLE
SELECT * FROM Learners;
ALTER TABLE Learners ADD COLUMN Updated_at TIMESTAMP;
ALTER TABLE Learners
MODIFY COLUMN  Created_at TIMESTAMP;
CREATE TABLE Learners(
	UserId INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    EmailId VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(12),
    School VARCHAR(100),
    Created_at TIME
);
ALTER TABLE Learners MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Learners MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;


-- INSTRUCTOR TABLE 
SELECT * FROM Instructor;
ALTER TABLE Instructor ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE Instructor(
    InstructorId INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    EmailId VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(12),
    Qualification VARCHAR(100),
    WorkExperience INT,
    Achievement VARCHAR(300)
);   
ALTER TABLE Instructor MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp; 
ALTER TABLE Instructor MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- COURSES TABLE
SELECT * FROM Courses;
ALTER TABLE Courses ADD COLUMN Updated_at TIMESTAMP;
CREATE TABLE Courses(
    CourseId INT PRIMARY KEY,
    InstructorId INT,
    Name VARCHAR(100),
    Description TEXT,
    Payment_Mode ENUM("Free","Paid"),
    Created_at TIME,
    FOREIGN KEY (InstructorId) REFERENCES Instructor(InstructorId)
);
ALTER TABLE Courses MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Courses MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- SYLLABUS TABLE
SELECT * FROM Syllabus;
ALTER TABLE Syllabus ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
ALTER TABLE Syllabus ADD COLUMN Assignments TEXT;
CREATE TABLE Syllabus(
    SyllabusId INT PRIMARY KEY,
    CourseId INT,
    VideoId INT,
	Notes TEXT,
	Quiz TEXT,
    Duration INT,
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
    FOREIGN KEY (VideoId) REFERENCES Videos(VideoId)
);
ALTER TABLE Syllabus MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Syllabus MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- QUIZ TABLE
SELECT * FROM QUIZ;
ALTER TABLE QUIZ ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
ALTER TABLE QUIZ ADD COLUMN Marks INT;
CREATE TABLE QUIZ(
   QuizId INT PRIMARY KEY,
   CourseId INT,
   Title VARCHAR(100),
   Questions TEXT,
   Answers TEXT,
   DueDate time,
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);
ALTER TABLE QUIZ MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE QUIZ MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;

-- ASSIGNMENTS TABLE
SELECT * FROM Assignment;
ALTER TABLE Assignment ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE Assignment(
   AssignmentId INT PRIMARY KEY,
   CourseId INT,
   Title VARCHAR(100),
   Description TEXT,
   Marks INT,
   DueDate time,
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);
ALTER TABLE Assignment MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Assignment MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;

-- CERTIFICATE TABLE
SELECT * FROM Certificate;
ALTER TABLE Certificate ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE Certificate(
   CertificateId INT PRIMARY KEY,
   CourseId INT,
   UserId INT,
   IssueDate TIME,
   ExpiryDate TIME ,
   CertificateCode VARCHAR(100),
   Status ENUM("Active","Expired"),
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
   FOREIGN KEY (Userid) REFERENCES Learners(Userid)
);
ALTER TABLE Certificate MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Certificate MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;

-- BADGES TABLE
SELECT * FROM Badges;
ALTER TABLE Badges ADD COLUMN( Updated_at TIMESTAMP);
ALTER TABLE Badges
MODIFY COLUMN  Earned_at TIMESTAMP;
CREATE TABLE Badges(
   BadgesId INT PRIMARY KEY,
   UserId INT,
   Name VARCHAR(100),
   Description TEXT,
   Earned_at TIME,
   Criteria TEXT,
   FOREIGN KEY (UserId) REFERENCES Learners(UserId)
);
ALTER TABLE Badges MODIFY COLUMN Earned_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Badges MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- PAYMENTS TABLE
SELECT * FROM Payments;
ALTER TABLE Payments ADD COLUMN( Updated_at TIMESTAMP);
ALTER TABLE Payments
MODIFY COLUMN  PaymentDate TIMESTAMP;
CREATE TABLE Payments(
   PaymentId INT PRIMARY KEY,
   CourseId INT,
   UserId INT,
   Amount DECIMAL,
   Payment_Mode ENUM("Free","Paid"),
   PaymentDate TIME,
   TransactionId INT,
   Status ENUM("Paid","Pending"),
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
   FOREIGN KEY (Userid) REFERENCES Learners(Userid)
);
ALTER TABLE Payments MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- BANKING_DETAILS TABLE
SELECT * FROM BANKING_DETAILS;
ALTER TABLE BANKING_DETAILS ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE BANKING_DETAILS(
  BankingId INT PRIMARY KEY,
  UserId INT,
  BankName VARCHAR(200),
  AccountNo VARCHAR(200),
  RoutingNo VARCHAR(200),
  FOREIGN KEY (Userid) REFERENCES Learners(Userid)
);
ALTER TABLE BANKING_DETAILS MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE BANKING_DETAILS MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- COMMENTS TABLE
SELECT * FROM COMMENTS;
ALTER TABLE COMMENTS ADD COLUMN( Updated_at TIMESTAMP);
ALTER TABLE COMMENTS
MODIFY COLUMN  CreatedAt TIMESTAMP;
CREATE TABLE COMMENTS(
  CommentId INT PRIMARY KEY,
  UserId INT,
  CourseId INT, 
  CommentText TEXT,
  CreatedAt TIME,
  FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
  FOREIGN KEY (Userid) REFERENCES Learners(Userid)
);
ALTER TABLE COMMENTS MODIFY COLUMN CreatedAt TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE COMMENTS MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- RATING_FEEDBACK TABLE
SELECT * FROM RATING_FEEDBACK;
ALTER TABLE RATING_FEEDBACK ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE RATING_FEEDBACK(
   RFId INT PRIMARY KEY,
   UserId INT,
   CourseId INT, 
   InstructorId INT,
   Rating INT,
   Feedback TEXT,
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
   FOREIGN KEY (Userid) REFERENCES Learners(Userid),
   FOREIGN KEY (InstructorId) REFERENCES Instructor(InstructorId)
);
ALTER TABLE RATING_FEEDBACK MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE RATING_FEEDBACK MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- REPORTS TABLE
SELECT * FROM REPORTS;
ALTER TABLE REPORTS ADD COLUMN( Updated_at TIMESTAMP,Created_at TIMESTAMP);
CREATE TABLE REPORTS(
   ReportId INT PRIMARY KEY,
   UserId INT,
   CourseId INT, 
   CertificateId INT,
   PaymentId INT,
   Status enum("Completed","In-Progress"),
   CourseScore DECIMAL,
   TimeSpent DECIMAL,
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
   FOREIGN KEY (Userid) REFERENCES Learners(Userid),
   FOREIGN KEY (CertificateId) REFERENCES Certificate(CertificateId),
   FOREIGN KEY (PaymentId) REFERENCES Payments(PaymentId)
);
ALTER TABLE REPORTS MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE REPORTS MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- CART TABLE
SELECT * FROM CART;
CREATE TABLE CART(
   CartId INT PRIMARY KEY,
   UserId INT,
   CourseId INT, 
   Total_Items INT,
   Total_Cost INT,
   Updated_at TIMESTAMP,
   Created_at TIMESTAMP,
   FOREIGN KEY (CourseId) REFERENCES Courses(CourseId),
   FOREIGN KEY (Userid) REFERENCES Learners(Userid)
);
ALTER TABLE CART MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE CART MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;

-- VIDEOS TABLE
SELECT * FROM Videos;
CREATE TABLE Videos (
    VideoId INT AUTO_INCREMENT PRIMARY KEY,
    CourseId INT,
    Name VARCHAR(255),
    Path VARCHAR(255),  
    Duration INT,        
    UploadedAt TIMESTAMP,
    UpdatedAt TIMESTAMP,
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);
ALTER TABLE Videos MODIFY COLUMN UploadedAt TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Videos MODIFY COLUMN UpdatedAt TIMESTAMP DEFAULT current_timestamp;

-- NOTIFICATIONS TABLE
CREATE TABLE Notifications(
   NotificationId INT PRIMARY KEY,
   UserId INT,
   InstructorId INT,
   AdminId INT,
   Notification TEXT,
   Status ENUM("Read","Unread"),
   Updated_at TIMESTAMP,
   Created_at TIMESTAMP,
   FOREIGN KEY (Userid) REFERENCES Learners(Userid),
   FOREIGN KEY (InstructorId) REFERENCES Instructor(InstructorId),
   FOREIGN KEY (AdminID) REFERENCES Admin(AdminID)
);
ALTER TABLE Notifications MODIFY COLUMN Created_at TIMESTAMP DEFAULT current_timestamp;
ALTER TABLE Notifications MODIFY COLUMN Updated_at TIMESTAMP DEFAULT current_timestamp;





