package net.doyouhike.app.wildbird.biz.db.bean;

import net.doyouhike.app.wildbird.biz.db.dao.CommentDao;
import net.doyouhike.app.wildbird.biz.db.dao.WbDaoSession;
import net.doyouhike.app.wildbird.biz.db.dao.WildBirdDao;
import net.doyouhike.app.wildbird.biz.model.bean.Comment;

import de.greenrobot.dao.DaoException;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "COMMENT".
 */
public class DbComment extends Comment {

    private String speciesID;

    /**
     * Used to resolve relations
     */
    private transient WbDaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient CommentDao myDao;

    private DbWildBird wildBird;
    private String wildBird__resolvedKey;


    public DbComment() {
    }

    public DbComment(Long commentID, String userID, String userName, Integer isLike, String avatar,
                     Integer likeNum, String content, String time, String speciesID) {
        super(commentID, isLike, userID, userName, avatar, likeNum, content, time);
        this.speciesID = speciesID;
    }

    public DbComment(String speciesID,Comment comment) {
        super(comment.getCommentID(),comment.getIsLike(),comment.getUserID(),
                comment.getUserName(),comment.getAvatar(),comment.getLikeNum(),
                comment.getContent(),comment.getTime());
        this.speciesID = speciesID;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(WbDaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommentDao() : null;
    }


    public String getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(String speciesID) {
        this.speciesID = speciesID;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    public DbWildBird getWildBird() {
        String __key = this.speciesID;
        if (wildBird__resolvedKey == null || wildBird__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WildBirdDao targetDao = daoSession.getWildBirdDao();
            DbWildBird wildBirdNew = targetDao.load(__key);
            synchronized (this) {
                wildBird = wildBirdNew;
                wildBird__resolvedKey = __key;
            }
        }
        return wildBird;
    }

    public void setWildBird(DbWildBird wildBird) {
        synchronized (this) {
            this.wildBird = wildBird;
            speciesID = wildBird == null ? null : wildBird.getSpeciesID();
            wildBird__resolvedKey = speciesID;
        }
    }

    /**
     * Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context.
     */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context.
     */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context.
     */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

}
