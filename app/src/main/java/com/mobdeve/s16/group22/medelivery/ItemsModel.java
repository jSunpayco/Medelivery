package com.mobdeve.s16.group22.medelivery;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;

public class ItemsModel {

    @DocumentId
    private DocumentReference postId;

    // Attributes
    private DocumentReference userRef;
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String imageUrl;

    // Default blank constructor for Firebase
    public ItemsModel() {

    }

    public ItemsModel(DocumentReference userRef, String itemName, String itemPrice, String itemQuantity,
                      String imageUrl) {
        this.userRef = userRef;
        this.imageUrl = imageUrl;
        this.setItemQuantity(itemQuantity);
        this.setItemName(itemName);
        this.setItemPrice(itemPrice);
    }

    public DocumentReference getPostId() {
        return postId;
    }

    public void setPostId(DocumentReference postId) {
        this.postId = postId;
    }

    public DocumentReference getUserRef() {
        return userRef;
    }

    public void setUserRef(DocumentReference userRef) {
        this.userRef = userRef;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}