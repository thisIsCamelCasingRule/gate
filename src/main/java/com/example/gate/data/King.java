package com.example.gate.data;

import lombok.Data;
import java.util.UUID;

@Data
public class King {

        private UUID id;

        private String name;
        private String kingdom;

        public King(){}

        public King(String name, String kingdom) {
            this.name = name;
            this.kingdom = kingdom;
        }


        public String getName() {
            return name;
        }

        public void setName(String newName) {
            this.name = newName;
        }

        public void setKingdom(String kingdom) {
            this.kingdom = kingdom;
        }

        public String getKingdom() {
            return kingdom;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

}
