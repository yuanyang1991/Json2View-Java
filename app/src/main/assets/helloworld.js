class RootView extends View {


    constructor() {
        super();

      
        this.style = {
            width: '100%',
            height: '100%',
            justifyContent: 'center',
            alignItems: 'center',
            backgroundColor: '#FFFFFF',
        }
    }
}


let data = [
    'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3207781657,3460758070&fm=27&gp=0.jpg',
    'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2735633715,2749454924&fm=27&gp=0.jpg',
    'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3464499095,1074840881&fm=27&gp=0.jpg',
]
let viewPager = new ViewPager();
viewPager.style = {
	width: Hummer.env.availableWidth,
    height: 170,
    itemSpacing: 20,
    edgeSpacing: 40,
    canLoop: true,
    autoPlay: true,
    loopInterval: 2000,
}

viewPager.onItemClick((p) => {
	console.log("click pos:", p);
})

viewPager.onItemView((p, v) => {
	let image = v;
	if (image != null) {
		image = new Image();
		image.style = {
			resize: 'cover'
		}
		image.src = data[p];
		return img;
	}	
})

viewPager.data = data;

let root = new RootView();
root.appendChild(viewPager);

Hummer.render(root);