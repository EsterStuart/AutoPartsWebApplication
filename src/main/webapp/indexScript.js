// JavaScript Logic
const prev = document.getElementById('prev-btn');
const next = document.getElementById('next-btn');
const list = document.getElementById('item-list');
const itemWidth = 360; // Adjusted item width to accommodate three items
const padding = 20; // Adjusted padding to maintain spacing between items

prev.addEventListener('click', () => {
    list.scrollLeft -= (itemWidth + padding);
});

next.addEventListener('click', () => {
    list.scrollLeft += (itemWidth + padding);
});
