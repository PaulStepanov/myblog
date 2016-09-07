/**
 * Created by Павел on 24-Aug-16.
 */
$(document).ready(function(){
    class ControlPost {
        constructor() {
            this.amount = null;
            this.lastId=null;
            $.ajax({
                method: 'GET',
                url: '/getAmountofPosts',
                dataType: 'text',
                success: (num) => {
                    this.amount = num;
                }
            }).done(()=>this.lastId=this.loadPost(this.amount, 5))
        }

        static createPost(text,id) {
            return `<div class="post col-md-12 " data-lastid=${id}>${text}</div>`
        }

        loadPost(lastid, amount) {
            let id=lastid-amount;
            if (id<=0) id=1;
            for (let i = lastid; i >= id; i--) {
                $.ajax({
                    method: 'GET',
                    url: '/getPost',
                    data: {
                        id: i
                    },
                    id:i,
                    cache: true,
                    dataType: 'html',
                    success: (blogdata)=> {
                        let block = blogdata;
                        $('.mainblog>.row').append(ControlPost.createPost(block,lastid));
                    }
                });
            }
            return lastid;
        }
    static clearPostsPage(){
        $('[data-lastid]').remove();
    }
    loadPrevPosts(){
    }
    loadNewPosts(){
    }
    }
    let contrl=new ControlPost();

});
