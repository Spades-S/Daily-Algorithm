class Twitter {

		/** Initialize your data structure here. */
		ArrayList<Integer> allPosts;
		HashMap<Integer, Integer> post2user;
		HashMap<Integer, ArrayList<Integer>> user2following;

		public Twitter() {
			allPosts = new ArrayList<Integer>();
			post2user = new HashMap<Integer, Integer>();
			user2following = new HashMap<Integer, ArrayList<Integer>>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			allPosts.add(tweetId);
			post2user.put(tweetId, userId);
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new ArrayList<Integer>();
			int cnt = 0;
			ArrayList<Integer> following = user2following.get(userId);
			for(int i = allPosts.size() - 1; i > -1 && cnt < 10; i--){
				int curTw = allPosts.get(i);
				int whoSendTw = post2user.get(curTw);
				if(whoSendTw == userId || (following != null && following.contains(whoSendTw))){
						res.add(curTw);
						cnt++;
				}
			}

			return res;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			ArrayList<Integer> newContent = user2following.getOrDefault(followerId, new ArrayList<Integer>());
			newContent.add(followeeId);
			user2following.put(followerId, newContent);

		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			ArrayList<Integer> newContent = user2following.get(followerId);
            if(newContent == null) return;
			newContent.remove((Integer) followeeId);
			user2following.put(followerId, newContent);

		}
	}