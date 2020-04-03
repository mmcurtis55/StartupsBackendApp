package com.example.StartupsBackendApp;

import java.util.ArrayList;

public class Health {
        private String status;
        private final long id;


        public Health(String status, long id){
            this.status = status;
            this.id =  id;
        }

        public String getStatus(){
            return status;
        }

        public long getId() {
            return id;
        }
}

