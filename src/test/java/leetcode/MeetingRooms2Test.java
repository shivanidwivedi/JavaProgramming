package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 17/07/20
 * @project JavaProgramming
 */
public class MeetingRooms2Test {

    @Test
    public void minMeetingRooms() {
        Assert.assertEquals(2, MeetingRooms2.minMeetingRooms(
                new int[][]{{0, 30},{5, 10},{15, 20}}
        ));
        Assert.assertEquals(1, MeetingRooms2.minMeetingRooms(
                new int[][]{{7, 10},{2, 4}}
        ));
    }
}