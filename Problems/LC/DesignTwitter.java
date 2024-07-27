import java.util.*;

class Twitter {
    class Tweet {
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, Set<Integer>> follows;
    int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        List<Tweet> hist = tweets.getOrDefault(userId, new ArrayList<>());
        hist.add(new Tweet(tweetId, timestamp++));
        tweets.put(userId, hist);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        List<Integer> res = new ArrayList<>();

        if (tweets.containsKey(userId)) {
            feed.addAll(tweets.get(userId));
        }

        if (follows.containsKey(userId)) {
            for (int followeeId : follows.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    feed.addAll(tweets.get(followeeId));
                }
            }
        }

        int count = 0;
        while (!feed.isEmpty() && count < 10) {
            res.add(feed.poll().tweetId);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> followers = follows.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        follows.put(followerId, followers);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            Set<Integer> followers = follows.get(followerId);
            followers.remove(followeeId);
            follows.put(followerId, followers);
        }
    }
}
