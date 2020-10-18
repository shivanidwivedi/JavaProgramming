package design_questions.online.book.reader;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 17/10/20
 * @project JavaProgramming
 */
public class UserManager {
    /**
     * User inventory
     */
    private HashMap<Integer, Profile> users;

    public UserManager(){
        users = new HashMap<Integer, Profile>();
    }

    /**
     * Adds a user with id and name
     * @param id
     * @param name
     * @return
     */
    public boolean addUser(int id, String name){
        if(users.containsKey(id)){
            return false;
        }
        users.put(id, new Profile(id, name));
        return true;
    }

    /**
     * Adds a user with user object
     * @param profile
     * @return
     */
    public boolean addUser(Profile profile){
        if(users.containsKey(profile.getUserId())){
            return false;
        }
        users.put(profile.getUserId(), profile);
        return true;
    }

    /**
     * Removes a user with id
     * @param id
     * @return
     */
    public boolean removeUser(int id){
        if (users.containsKey(id)){
            users.remove(id);
            return true;
        }
        return false;
    }

    /**
     * Removes a user with user object
     * @param profile
     * @return
     */

    public boolean removeUser(Profile profile){
        if(users.containsKey(profile.getUserId())){
            users.remove(profile.getUserId());
            return true;
        }
        return false;
    }

    /**
     * Finds a user with id
     * @param id
     * @return
     */
    public Profile findUser(int id){
        return users.get(id);
    }
}
