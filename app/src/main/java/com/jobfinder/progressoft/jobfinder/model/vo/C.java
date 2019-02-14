package com.jobfinder.progressoft.jobfinder.model.vo;

import android.os.Environment;

public class C {
    public static final int BUTTON_STATUS_NORMAL = 0;
    public static final int BUTTON_STATUS_LOADING = 50;
    public static final int BUTTON_STATUS_SUCCESSFUL = 100;
    public static final int BUTTON_STATUS_FAILURE = -1;

    public static final int ERROR_USER_NOT_FOUND = 2;
    public static final int ERROR_WRONG_VERIFICATION_CODE = 3;

    public static final int MASK_FADE_SPEED = 200;
    public static final int MASK_OPACITY = 180;
    public static final int POP_AFTER_MS = 500;
    public static final int RIPPLE_DELAY = 100;
    public static final int ITEMS_COUNT_TO_LOAD_MORE = 10;
    public static final int DEFAULT_REMINDER_MINUTES = 60;
    public static final int LIST_VIEW_ANIMATION_TIME = 400;
    public static final int LIST_VIEW_ANIMATION_OFFSET_TIME = 75;
    public static final int FADE_DURATION = 500;
    public static final int FLIPX_DURATION = 750;
    public static final int DETAILS_ANIM_DURATION = 350;

    public static final int REQUEST_CODE = 567;
    public static final int RESULT_CODE = 678;

    public static final String EXTRA_OPERATOR_ID = "operator_id";
    public static final String EXTRA_COUNTRY_ID = "country_id";
    public static final String EXTRA_PHONE_NUMBER = "phone_number";
    public static final String EXTRA_SCHOOL = "school";
    public static final String EXTRA_ADMIN_SCHOOL = "admin_school";
    public static final String EXTRA_TEACHER_SCHOOL = "teacher_school";
    public static final String EXTRA_CLASSES_STUDENTS = "classes_students";
    public static final String EXTRA_COMMUNICATION_LOG = "communication_log";
    public static final String EXTRA_USERS_LIST = "users_list";
    public static final String EXTRA_USERS = "users";


    public static final String EXTRA_STUDENT = "student";
    public static final String EXTRA_CONTENT_TYPE = "category";
    public static final String EXTRA_ADMIN_CONTENT_TYPE = "admin_category";
    public static final String EXTRA_TEACHER_CONTENT_TYPE = "teacher_category";
    public static final String EXTRA_CONTENT = "content";
    public static final String EXTRA_MULTI_USER = "multi_user";
    public static final String EXTRA_ADMIN_CONTENT = "admin_content";
    public static final String EXTRA_TEACHER_CONTENT = "teacher_content";
    public static final String EXTRA_ADMIN_CONTENT_DETAILS = "admin_content_details";
    public static final String EXTRA_TEACHER_CONTENT_DETAILS = "teacher_content_details";



    public static final String EXTRA_LAST_MESSAGE = "last_message";
    public static final String EXTRA_ADMIN_LAST_MESSAGE = "admin_last_message";
    public static final String EXTRA_TEACHER_LAST_MESSAGE = "teacher_last_message";
    public static final String EXTRA_STUDENT_ID = "student_id";
    public static final String EXTRA_STUDENT_NAME = "student_name";
    public static final String EXTRA_SHOW_FORMS = "show_forms";
    public static final String EXTRA_FORM_ID = "form_id";
    public static final String EXTRA_FORM_NAME = "form_name";
    public static final String EXTRA_TEACHER_ID = "teacher_id";
    public static final String EXTRA_TEACHER_NAME = "teacher_name";
    public static final String EXTRA_SUBJECT = "subject";
    public static final String EXTRA_SUBJECT_EDITABLE = "subject_editable";
    public static final String EXTRA_MESSAGE_PAGE_TITLE = "message_page_title";
    public static final String EXTRA_IS_REDIRECTED = "is_redirected";
    public static final String EXTRA_ABOUT_US = "about_us";
    public static final String EXTRA_SCHOOL_ID = "school_id";
    public static final String EXTRA_ADMIN_ID = "admin_id";

    public static final String EXTRA_SEND_SMS_CHECK = "send_sms";
    public static final String EXTRA_CONTENT_TARGET = "content_target";
    public static final String EXTRA_TARGET_ID_LIST= "target_id_list";
    public static final String EXTRA_GROUP_ID_LIST = "group_id_list";

    public static final String EXTRA_NOTIFICATION = "notification";
    public static final String EXTRA_IGNORE = "ignore";
    public static final String EXTRA_COUNTRY_CODE = "country_code";
    public static final String EXTRA_CALLING_CODE = "calling_code";

    public static final String FILE_SCHOOLS = "schools";
    public static final String FILE_SCHOOLS_CONTACT = "schools_contact";
    public static final String FILE_USER_RESPONSE = "user_response";
    public static final String FILE_CLASSES = "classes";
    public static final String FILE_STUDENTS= "student";
    public static final String FILE_TEACHER_CLASSES = "teacher_classes";
    public static final String FILE_TEACHER_COURSES = "teacher_courses";
    public static final String FILE_ADMIN_SCHOOLS = "admin_schools";
    public static final String FILE_TEACHER_SCHOOLS = "teacher_schools";
    public static final String FILE_LAST_MESSAGES = "last_messages";
    public static final String FILE_ADMIN_LAST_MESSAGES = "admin_last_messages";
    public static final String FILE_TEACHER_LAST_MESSAGES = "teacher_last_messages";
    public static final String FILE_CONTACTS = "contacts";
    public static final String FILE_CONTACT_US = "contact_us";
    public static final String FILE_ABOUT_US = "about_us";
    public static final String FILE_CONTENT_DETAILS = "content_details";
    public static final String FILE_ADMIN_CONTENT = "admin_content";
    public static final String FILE_TEACHER_CONTENT = "teacher_content";
    public static final String FILE_ADMIN_CONTENT_DETAILS = "admin_content_details";
    public static final String FILE_TEACHER_CONTENT_DETAILS = "teacher_content_details";
    public static final String FILE_BADGES = "badges";
    public static final String FILE_ADMIN_BADGES = "admin_badges";
    public static final String FILE_TEACHER_BADGES = "teacher_badges";
    public static final String FILE_NEWS = "news";
    public static final String FILE_FORMS = "forms";

    public static final String PREF_PHONE_NUMBER = "phone_number";
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_USER_TYPE = "user_type";
    public static final String PREF_COMPOUND_PARENT_ID = "compound_parent_id";
    public static final String PREF_COMPOUND_ADMIN_ID = "compound_admin_id";
    public static final String PREF_COMPOUND_ADMIN_TYPE = "compound_admin_type";
    public static final String PREF_COMPOUND_USER_TYPE = "compound_user_type";

    public static final String PREF_COMPOUND_TEACHER_ID = "compound_teacher_id";
    public static final String PREF_CLICK_DATE_LOCAL = "click_date";
    public static final String PREF_ADMIN_CLICK_DATE_LOCAL = "admin_click_date";
    public static final String PREF_TEACHER_CLICK_DATE_LOCAL = "teacher_click_date";

    public static final String PREF_REGISTRATION_ID = "registration_id";
    public static final String PREF_APP_VERSION = "app_version";
    public static final String PREF_IS_USER_REGISTERED = "is_user_registered";
    public static final String PREF_PROFILE_NAME = "profile_name";
    public static final String PREF_PROFILE_SECONDARY_PHONE = "profile_secondary_phone";
    public static final String PREF_PROFILE_EMAIL = "profile_email";
    public static final String PREF_PROFILE_LANGUAGE = "profile_language";
    public static final String PREF_PROFILE_SHOW_PHONE = "profile_show_phone";
    public static final String PREF_PROFILE_ENABLE_NOTIFICATIONS = "profile_enable_notifications";
    public static final String PREF_PROFILE_ENABLE_SMS = "profile_enable_sms";
    public static final String PREF_PROFILE_ENABLE_PRIVATE_MESSAGES = "profile_enable_private_messages";
    public static final String PREF_PROFILE_IS_CACHED = "profile_is_cached";
    public static final String PREF_MESSAGE_READ = "message_read";
    public static final String PREF_ADMIN_MESSAGE_READ = "admin_message_read";
    public static final String PREF_TEACHER_MESSAGE_READ = "teacher_message_read";
    public static final String PREF_CONTENT_READ = "content_read";
    public static final String PREF_ADMIN_CONTENT_READ = "admin_content_read";
    public static final String PREF_TEACHER_CONTENT_READ = "teacher_content_read";
    public static final String PREF_BANNER_IMAGE = "banner_image";

    public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_DEFAULT = "HH:mm:ss";
    public static final String GCM_SENDER_ID = "446627001795";

    public static final String DIRECTORY_MOFAKERA = Environment.getExternalStorageDirectory().getPath() + "/Mofakera/";
    public static final String DIRECTORY_ATTACHMENTS = DIRECTORY_MOFAKERA + "Attachments/";
    public static final String DIRECTORY_LOGS = DIRECTORY_MOFAKERA + "Logs/";

    public static final String MESSAGE_SOURCE_PARENT = "parent";
    public static final String MESSAGE_SOURCE_TEACHER = "teacher";
}
