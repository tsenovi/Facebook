package org.vso.models.data;

import jakarta.persistence.*;
import org.vso.constants.FriendStatus;

@Entity
@Table(name = "friendRequests")
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long friendId;

    @Column
    private FriendStatus friendStatus;


    public FriendRequest() {
    }

    public FriendRequest(Long userId, Long friendId, FriendStatus friendStatus) {
        this.userId = userId;
        this.friendId = friendId;
        this.friendStatus = friendStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public FriendStatus getFriendStatus() {
        return friendStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public void setFriendStatus(FriendStatus friendStatus) {
        this.friendStatus = friendStatus;
    }
}
