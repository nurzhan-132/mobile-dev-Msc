package com.example.instagram_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FeedPost() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        val (avatar, name, username, moreOptions, img, like, comment, repost, save, likes, caption, comments, time) = createRefs()

        // Image for the avatar
        Image(painter = painterResource(id = R.drawable.sample_avatar),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(44.dp) ///////////
                .clip(CircleShape)
                .constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        // Text for the Name
        Text(
            text = "Nurzhan Momynkul",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        // Text for the Username
        Text(
            text = "nurzhan.1s",
            color = Color.Gray,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(username) {
                top.linkTo(name.bottom, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .constrainAs(moreOptions) {
                    end.linkTo(parent.end)
                    top.linkTo(avatar.top)
                    bottom.linkTo(avatar.bottom)
                }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_moreoptions_icon),
                contentDescription = null
            )
        }

        Image(
            painter = painterResource(id = R.drawable.nurzhan),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(img) {
                    top.linkTo(avatar.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.like_icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(like) {
                    top.linkTo(img.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.comment_icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(comment) {
                    top.linkTo(img.bottom, margin = 16.dp)
                    start.linkTo(like.end, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.repost_icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(repost) {
                    top.linkTo(img.bottom, margin = 16.dp)
                    start.linkTo(comment.end, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.save_icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(save) {
                    top.linkTo(img.bottom, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        )

        Text(
            text = "1,123 likes",
            style = MaterialTheme.typography.titleSmall,
            color = Color.White,
            modifier = Modifier.constrainAs(likes) {
                top.linkTo(like.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "Some wise words of wisdom for captions...",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.constrainAs(caption) {
                top.linkTo(likes.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "View all 13 comments",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.constrainAs(comments) {
                top.linkTo(caption.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "1 day ago",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.constrainAs(time) {
                top.linkTo(comments.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFeedPost() {
    FeedPost()
}