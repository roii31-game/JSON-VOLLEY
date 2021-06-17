package com.example.myapplicationnew.adapter;

import java.util.Comparator;

public class ListofItems {
        private int id;
        private int listId;
        private String name;

        public static Comparator<ListofItems> ListofItemsAZComparator = new Comparator<ListofItems>(){

            @Override
            public int compare(ListofItems o1, ListofItems o2) {
                return o1.getListId() - o2.getListId();
            }
        };

    public static Comparator<ListofItems> ListofItemsZAComparator = new Comparator<ListofItems>(){

        @Override
        public int compare(ListofItems o1, ListofItems o2) {
            return o2.getListId() - o1.getListId();
        }
    };

    public static Comparator<ListofItems> ListofItemsNumberAscendingComparator = new Comparator<ListofItems>(){

        @Override
        public int compare(ListofItems o1, ListofItems o2) {
            return o1.getId() - o2.getId();
        }
    };

    public static Comparator<ListofItems> ListofItemsNumberDescendingComparator = new Comparator<ListofItems>(){

        @Override
        public int compare(ListofItems o1, ListofItems o2) {
            return o2.getId() - o1.getId();
        }
    };

    public static Comparator<ListofItems> ListofItemsIDAscendingComparator = new Comparator<ListofItems>(){

        @Override
        public int compare(ListofItems o1, ListofItems o2) {
            return o1.getId() - o2.getId();
        }
    };

    public static Comparator<ListofItems> ListofItemsIDDescendingComparator = new Comparator<ListofItems>(){

        @Override
        public int compare(ListofItems o1, ListofItems o2) {
            return o2.getId() - o1.getId();
        }
    };



    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getListId() {
            return listId;
        }

        public void setListId(int listId) {
            this.listId = listId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}
